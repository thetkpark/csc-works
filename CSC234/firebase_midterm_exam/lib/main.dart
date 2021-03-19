import 'package:flutter/material.dart';
import 'package:email_validator/email_validator.dart';
import 'package:http/http.dart' as http;
import 'package:provider/provider.dart';

// Sethanant Pipatpakorn 62130500230
void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider(
      create: (ctx) => ApplicationStates(),
      builder: (ctx, _) => MaterialApp(
        title: 'CSC234 Midterm App',
        theme: ThemeData(primaryColor: Colors.teal),
        home: HomePage(),
      ),
    );
  }
}

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  final _form = GlobalKey<FormState>();
  String email = '';
  String password = '';

  void _onFormChange() {
    this._form.currentState!.validate();
  }

  void _onFormSubmit() {
    final isValid = this._form.currentState!.validate();
    if (!isValid) return;
    this._form.currentState!.save();

    Provider.of<ApplicationStates>(context, listen: false)
        .addUser(email, password);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Sign-in form'),
      ),
      body: Form(
        key: _form,
        child: Padding(
          padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 20),
          child: ListView(
            children: [
              TextFormField(
                decoration: InputDecoration(labelText: 'Email'),
                keyboardType: TextInputType.emailAddress,
                textInputAction: TextInputAction.next,
                validator: (email) => EmailValidator.validate(email!)
                    ? null
                    : "Invalid email address",
                onChanged: (_) => _onFormChange(),
                onSaved: (value) {
                  this.email = value!;
                },
              ),
              TextFormField(
                decoration: InputDecoration(labelText: 'Password'),
                keyboardType: TextInputType.number,
                textInputAction: TextInputAction.done,
                validator: (password) {
                  RegExp regex = new RegExp(r"^\d+$");
                  if (!regex.hasMatch(password!))
                    return 'Password can only be number';
                  else
                    return null;
                },
                onChanged: (_) => _onFormChange(),
                onSaved: (value) {
                  this.password = value!;
                },
              ),
              SizedBox(
                height: 20,
              ),
              TextButton(
                onPressed: _onFormSubmit,
                child: Text(
                  'Sign in',
                  style: TextStyle(color: Theme.of(context).primaryColor),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}

class SecondPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final userInfo = Provider.of<ApplicationStates>(context).userInfo;
    return Scaffold(
      appBar: AppBar(
        title: Text('Your Infomation'),
      ),
      body: Column(
        children: [
          Text(userInfo.email),
          Text(userInfo.password),
        ],
      ),
    );
  }
}

class UserInformation {
  String email;
  String password;

  UserInformation(this.email, this.password);
}

class ApplicationStates with ChangeNotifier {
  UserInformation userInfo = UserInformation('', '');
  var url = "https://csc234-midterm-exam-default-rtdb.firebaseio.com/users";

  // ApplicationState() {
  //   init();
  // }

  // Future<void> init() async {
  //   await Firebase.initializeApp();
  // }

  void addUser(String email, String password) {
    this.userInfo = UserInformation(email, password);
    // http.post(url, body: {"email": email, "password": password});
  }
}

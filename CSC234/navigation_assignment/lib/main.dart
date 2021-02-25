import 'package:flutter/material.dart';

// Sethanant Pipatpakorn 62130500230
void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Navigation Assignment',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MainScreen(),
      routes: {
        Detail01Screen.routeName: (ctx) => Detail01Screen('text01'),
        Detail02Screen.routeName: (ctx) => Detail02Screen('text02'),
      },
    );
  }
}

class MainScreen extends StatefulWidget {
  @override
  _MainScreenState createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  final _form = GlobalKey<FormState>();

  var _text = '';

  void _onSave() {
    if (!_form.currentState.validate()) {
      return;
    }
    _form.currentState.save();
    Navigator.of(context).pushNamed(_text);
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Navigation Assignment 62230'),
      ),
      body: SingleChildScrollView(
        padding: EdgeInsets.all(20),
        child: Form(
          key: _form,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.center,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              TextFormField(
                decoration: InputDecoration(labelText: 'Enter text'),
                onSaved: (value) => _text = value,
                validator: (value) => value == 'text01' || value == 'text02'
                    ? null
                    : 'Please enter "text01" or "text02"',
              ),
              SizedBox(height: 20),
              RaisedButton(
                child: Text('Enter'),
                onPressed: _onSave,
              )
            ],
          ),
        ),
      ),
    );
  }
}

class Detail01Screen extends StatelessWidget {
  static const routeName = 'text01';
  final String text;

  const Detail01Screen(this.text);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Navigation Assignment 62230'),
      ),
      body: Container(
        width: double.infinity,
        margin: EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Text(text),
            RaisedButton(
              child: Text('Back'),
              onPressed: () {
                Navigator.of(context).pop();
              },
            )
          ],
        ),
      ),
    );
  }
}

class Detail02Screen extends StatelessWidget {
  static const routeName = 'text02';
  final String text;

  const Detail02Screen(this.text);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Navigation Assignment 62230'),
      ),
      body: Container(
        width: double.infinity,
        margin: EdgeInsets.all(20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.start,
          children: [
            Text(text),
            RaisedButton(
              child: Text('Back'),
              onPressed: () {
                Navigator.of(context).pop();
              },
            )
          ],
        ),
      ),
    );
  }
}

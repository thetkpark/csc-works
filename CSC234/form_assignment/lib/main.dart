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
      title: 'Form Assignment',
      theme: ThemeData(
        primarySwatch: Colors.cyan,
        accentColor: Colors.amber.shade200,
      ),
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  @override
  _MyHomePageState createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  final _studentIdFocusNode = FocusNode();
  final _nameFocusNode = FocusNode();
  final _form = GlobalKey<FormState>();

  var _name = '';
  var _studentId = '';

  void _saveForm() {
    final isValid = this._form.currentState.validate();
    if (!isValid) {
      return;
    }
    this._form.currentState.save();
    showDialog(
      context: context,
      builder: (ctx) => AlertDialog(
        title: Text('Your information'),
        content: Container(
          height: 100,
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.start,
            children: [
              Text('Name: $_name'),
              SizedBox(height: 10),
              Text('Student ID: $_studentId'),
            ],
          ),
        ),
        actions: [
          FlatButton(
            child: Text('Okay'),
            onPressed: () {
              Navigator.of(context).pop();
            },
          ),
        ],
      ),
    );
  }

  @override
  void dispose() {
    _studentIdFocusNode.dispose();
    _nameFocusNode.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Form Fields'),
      ),
      body: Container(
        padding: EdgeInsets.all(20),
        child: Form(
          key: _form,
          child: Column(
            children: [
              TextFormField(
                decoration: InputDecoration(labelText: 'Name'),
                textInputAction: TextInputAction.next,
                focusNode: _nameFocusNode,
                onFieldSubmitted: (_) {
                  FocusScope.of(context).requestFocus(_studentIdFocusNode);
                },
                validator: (value) =>
                    value.isEmpty ? 'Please enter name' : null,
                onSaved: (value) => this._name = value,
              ),
              TextFormField(
                decoration: InputDecoration(labelText: 'Student ID'),
                textInputAction: TextInputAction.done,
                keyboardType: TextInputType.number,
                focusNode: _studentIdFocusNode,
                onFieldSubmitted: (_) {
                  FocusScope.of(context).requestFocus(_nameFocusNode);
                },
                validator: (value) {
                  if (value.isEmpty) return 'Please enter your student ID';
                  if (value.length != 11)
                    return 'Student ID should be 11 digits';
                  return null;
                },
                onSaved: (value) => this._studentId = value,
              ),
              SizedBox(height: 50),
              RaisedButton(
                child: Text('Done'),
                color: Theme.of(context).accentColor,
                onPressed: _saveForm,
              ),
            ],
          ),
        ),
      ),
    );
  }
}

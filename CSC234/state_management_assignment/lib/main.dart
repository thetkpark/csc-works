import 'package:flutter/material.dart';

// Sethanant Pipatpakorn 62130500230
void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('State Management'),
        ),
        body: Center(
          child: TapboxC(),
        ),
      ),
    );
  }
}

class TapboxC extends StatefulWidget {
  _TapboxCState createState() => _TapboxCState();
}

class _TapboxCState extends State<TapboxC> {
  bool _highlight = false;
  String _textToShow = 'Inactive';
  bool _isActive = false;

  void _handleTapDown(TapDownDetails details) {
    setState(() {
      _textToShow = 'PRESSED';
      _highlight = true;
    });
  }

  void _handleTapUp(TapUpDetails details) {
    setState(() {
      _highlight = false;
    });
  }

  void _handleTapCancel() {
    setState(() {
      _highlight = false;
    });
  }

  void _handleTap() {
    this._isActive = !this._isActive;
    _textToShow = this._isActive ? 'Active' : 'Inactive';
  }

  Widget build(BuildContext context) {
    return GestureDetector(
      onTapDown: _handleTapDown, // Handle the tap events in the order that
      onTapUp: _handleTapUp, // they occur: down, up, tap, cancel
      onTap: _handleTap,
      onTapCancel: _handleTapCancel,
      child: Container(
        child: Center(
          child: Text(
            _textToShow,
            style: TextStyle(fontSize: 32.0, color: Colors.white),
          ),
        ),
        width: 200.0,
        height: 200.0,
        decoration: BoxDecoration(
          color: this._isActive ? Colors.lightGreen[700] : Colors.grey[600],
          border: _highlight
              ? Border.all(
                  color: Theme.of(context).accentColor,
                  width: 10.0,
                )
              : null,
        ),
      ),
    );
  }
}

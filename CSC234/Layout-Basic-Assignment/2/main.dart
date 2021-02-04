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
      title: 'Sethanant Pipatpakorn 62130500230',
      theme: ThemeData(
        primarySwatch: Colors.green,
        visualDensity: VisualDensity.adaptivePlatformDensity,
      ),
      home: Scaffold(
        appBar: AppBar(title: Text('Sethanant Pipatpakorn 62130500230')),
        body: Column(
          children: [
            Row(
              children: [
                Padding(
                  padding: const EdgeInsets.all(10),
                  child: Icon(
                    Icons.account_circle,
                    size: 50,
                  ),
                ),
                Column(
                  mainAxisSize: MainAxisSize.min,
                  crossAxisAlignment: CrossAxisAlignment.start,
                  children: [
                    Text(
                      'Sethanant Pipatpakorn',
                      style: Theme.of(context).textTheme.headline5,
                    ),
                    Text('Backend Developer')
                  ],
                )
              ],
            ),
            // SizedBox(height: 1),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text('888/73 Parque'),
                SizedBox(
                  width: 60,
                ),
                Text('62130500230')
              ],
            ),
            SizedBox(height: 20),
            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Icon(Icons.accessibility),
                Icon(Icons.timer),
                Icon(Icons.phone_android),
                Icon(Icons.phone_iphone),
              ],
            )
          ],
        ),
      ),
    );
  }
}

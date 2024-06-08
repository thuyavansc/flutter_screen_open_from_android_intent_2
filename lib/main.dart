import 'package:android_intent_plus/android_intent.dart';
import 'package:android_intent_plus/flag.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Intent Test',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: HomePage(),
      routes: {
        '/FullScreenAlarmPage': (context) {
          final args = ModalRoute.of(context)!.settings.arguments as Map<String, dynamic>?;
          return FullScreenAlarmPage(
            title: args?['title'] ?? 'Alarm',
            description: args?['body'] ?? 'Alarm triggered',
          );
        },
      },
    );
  }
}

class HomePage extends StatelessWidget {
  static const platform = MethodChannel('your_channel_name');

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Home Page'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            _openAlarmScreen();
          },
          child: Text('Open Alarm Screen'),
        ),
      ),
    );
  }

  Future<void> _openAlarmScreen() async {
    try {
      await platform.invokeMethod('startFullScreenActivity', {
        'title': 'Alarm Title',
        'body': 'This is the alarm body',
      });
    } on PlatformException catch (e) {
      print("Failed to open alarm screen: '${e.message}'.");
    }
  }
}

class FullScreenAlarmPage extends StatelessWidget {
  final String title;
  final String description;

  FullScreenAlarmPage({required this.title, required this.description});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(title),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(description),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                // Stop the alarm and navigate back
                Navigator.pop(context);
              },
              child: Text('Stop Alarm'),
            ),
          ],
        ),
      ),
    );
  }
}



// void main() {
//   runApp(MyApp());
// }
//
// class MyApp extends StatelessWidget {
//   @override
//   Widget build(BuildContext context) {
//     return MaterialApp(
//       title: 'Flutter Intent Test',
//       theme: ThemeData(
//         primarySwatch: Colors.blue,
//       ),
//       home: HomePage(),
//       routes: {
//         '/FullScreenAlarmPage': (context) {
//           final args = ModalRoute.of(context)!.settings.arguments as Map<String, dynamic>?;
//           return FullScreenAlarmPage(
//             title: args?['title'] ?? 'Alarm',
//             description: args?['body'] ?? 'Alarm triggered',
//           );
//         },
//       },
//     );
//   }
// }
//
// class HomePage extends StatelessWidget {
//   static const platform = MethodChannel('your_channel_name');
//
//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: Text('Home Page'),
//       ),
//       body: Center(
//         child: ElevatedButton(
//           onPressed: () {
//             // Call the method to open the alarm screen using native code
//             _triggerFullScreenAlarm('Alarm Title', 'Alarm Description');
//           },
//           child: Text('Open Alarm Screen'),
//         ),
//       ),
//     );
//   }
//
//   void _triggerFullScreenAlarm(String title, String description) {
//     platform.invokeMethod('startFullScreenActivity', {'title': title, 'body': description});
//   }
// }
//
// class FullScreenAlarmPage extends StatelessWidget {
//   final String title;
//   final String description;
//
//   FullScreenAlarmPage({required this.title, required this.description});
//
//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       appBar: AppBar(
//         title: Text(title),
//       ),
//       body: Center(
//         child: Column(
//           mainAxisAlignment: MainAxisAlignment.center,
//           children: [
//             Text(description),
//             SizedBox(height: 20),
//             ElevatedButton(
//               onPressed: () {
//                 // Stop the alarm and navigate back
//                 Navigator.pop(context);
//               },
//               child: Text('Stop Alarm'),
//             ),
//           ],
//         ),
//       ),
//     );
//   }
// }

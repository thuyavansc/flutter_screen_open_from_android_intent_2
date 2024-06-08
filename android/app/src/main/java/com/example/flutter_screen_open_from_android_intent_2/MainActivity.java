package com.example.flutter_screen_open_from_android_intent_2;
//
//import io.flutter.embedding.android.FlutterActivity;
//
//public class MainActivity extends FlutterActivity {
//}


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {

    private static final String CHANNEL = "your_channel_name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Handle intent if the app is launched via the intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String body = intent.getStringExtra("body");
        if (title != null && body != null) {
            startFullScreenAlarmActivity(title, body);
        } else {
            Log.d("MainActivity", "No title or body in intent");
        }
    }

    private void startFullScreenAlarmActivity(String title, String body) {
        Log.d("MainActivity", "startFullScreenAlarmActivity");
        Intent intent = FlutterActivity.withNewEngine()
                .initialRoute("/FullScreenAlarmPage?title=" + title + "&body=" + body)
                .build(this);
        startActivity(intent);
    }

    @Override
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);

        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if (call.method.equals("startFullScreenActivity")) {
                                String title = call.argument("title");
                                String body = call.argument("body");
                                startFullScreenAlarmActivity(title, body);
                                result.success(null);
                            } else {
                                result.notImplemented();
                            }
                        }
                );
    }
}


//
//public class MainActivity extends FlutterActivity {
//    private static final String CHANNEL = "your_channel_name";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // Handle intent if the app is launched via the intent
//        Intent intent = getIntent();
//        String title = intent.getStringExtra("title");
//        String body = intent.getStringExtra("body");
//        Log.d("-----------------MainActivity", "onCreate");
//        if (title != null && body != null) {
//            startFullScreenAlarmActivity(title, body);
//        } else {
//            Log.d("-------------MainActivity", "No title or body in intent");
//        }
//    }
//
//    private void startFullScreenAlarmActivity(String title, String body) {
//        Log.d("-----------------MainActivity", "startFullScreenAlarmActivity");
//
//        // Start the Flutter full-screen alarm page
//        Intent intent = FlutterActivity.withNewEngine()
//                .initialRoute("/FullScreenAlarmPage?title=" + title + "&body=" + body)
//                .build(this);
//        startActivity(intent);
//    }
//
//    @Override
//    public void configureFlutterEngine(FlutterEngine flutterEngine) {
//        Log.d("-----------------MainActivity", "configureFlutterEngine");
//
//        super.configureFlutterEngine(flutterEngine);
//
//        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
//                .setMethodCallHandler(
//                        (call, result) -> {
//                            if (call.method.equals("startFullScreenActivity")) {
//                                String title = call.argument("title");
//                                String body = call.argument("body");
//                                Log.d("-----------------MainActivity", "IF - configureFlutterEngine");
//
//                                startFullScreenAlarmActivity(title, body);
//                                result.success(null);
//                            } else {
//                                result.notImplemented();
//                            }
//                        }
//                );
//    }
//}

//with fltter intent plus package - not working
//public class MainActivity extends FlutterActivity {
//    private static final String CHANNEL = "your_channel_name";
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // Handle intent if the app is launched via the intent
//        Intent intent = getIntent();
//        String title = intent.getStringExtra("title");
//        String body = intent.getStringExtra("body");
//        if (title != null && body != null) {
//            startFullScreenAlarmActivity(title, body);
//        } else {
//            Log.d("MainActivity", "No title or body in intent");
//        }
//    }
//
//    private void startFullScreenAlarmActivity(String title, String body) {
//        // Start the Flutter full-screen alarm page
//        Intent intent = FlutterActivity.withNewEngine()
//                .initialRoute("/FullScreenAlarmPage?title=" + title + "&body=" + body)
//                .build(this);
//        startActivity(intent);
//    }
//
//    @Override
//    public void configureFlutterEngine(FlutterEngine flutterEngine) {
//        super.configureFlutterEngine(flutterEngine);
//
//        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
//                .setMethodCallHandler(
//                        (call, result) -> {
//                            if (call.method.equals("startFullScreenActivity")) {
//                                String title = call.argument("title");
//                                String body = call.argument("body");
//                                startFullScreenAlarmActivity(title, body);
//                                result.success(null);
//                            } else {
//                                result.notImplemented();
//                            }
//                        }
//                );
//    }
//}
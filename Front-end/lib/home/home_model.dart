import '/components/upload_widget.dart';
import '/flutter_flow/flutter_flow_util.dart';
import 'home_widget.dart' show HomeWidget;
import 'package:flutter/material.dart';

class HomeModel extends FlutterFlowModel<HomeWidget> {
  ///  State fields for stateful widgets in this page.

  // Model for Upload component.
  late UploadModel uploadModel;

  @override
  void initState(BuildContext context) {
    uploadModel = createModel(context, () => UploadModel());
  }

  @override
  void dispose() {
    uploadModel.dispose();
  }
}

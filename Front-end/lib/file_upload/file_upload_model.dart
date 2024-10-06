import '/components/upload_widget.dart';
import '/flutter_flow/flutter_flow_util.dart';
import 'file_upload_widget.dart' show FileUploadWidget;
import 'package:flutter/material.dart';

class FileUploadModel extends FlutterFlowModel<FileUploadWidget> {
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

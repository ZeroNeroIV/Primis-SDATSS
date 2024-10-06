import '/components/upload_widget.dart';
import '/flutter_flow/flutter_flow_theme.dart';
import '/flutter_flow/flutter_flow_util.dart';
import '/flutter_flow/flutter_flow_widgets.dart';
import 'file_upload_widget.dart' show FileUploadWidget;
import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:provider/provider.dart';

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

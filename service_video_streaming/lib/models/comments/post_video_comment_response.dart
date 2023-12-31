
import 'package:flutter_netflix_responsive_ui/models/comments/post_video_comment.dart';

class PostVideoCommentsResponse{

  final PostVideoComments videoComments;
  final String error;

  PostVideoCommentsResponse(this.videoComments, this.error);

  PostVideoCommentsResponse.fromJson(dynamic json)
      : videoComments = PostVideoComments.fromJson(json),
        error = "";

  PostVideoCommentsResponse.withError(String errorValue)
      : videoComments = PostVideoComments(),
        error = errorValue;
}
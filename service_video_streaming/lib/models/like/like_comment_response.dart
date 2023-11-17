
import 'package:flutter_netflix_responsive_ui/models/like/like_comment.dart';

class LikeCommentResponse{

  final LikeComment likeData;
  final String error;

  LikeCommentResponse(this.likeData, this.error);

  LikeCommentResponse.fromJson(dynamic json)
      : likeData = LikeComment.fromJson(json),
        error = "";

  LikeCommentResponse.withError(String errorValue)
      : likeData = LikeComment(),
        error = errorValue;

}
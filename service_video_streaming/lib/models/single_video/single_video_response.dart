
import 'package:flutter_netflix_responsive_ui/models/single_video/single_video.dart';

class SingleVideoResponse {
  final SingleVideo singleVideo;
  final String error;

  SingleVideoResponse(this.singleVideo, this.error);

  SingleVideoResponse.fromJson(dynamic json)
      : singleVideo = SingleVideo.fromJson(json),
        error = ""

  SingleVideoResponse.withError(String errorValue)
      : singleVideo = SingleVideo(),
        error = errorValue

}
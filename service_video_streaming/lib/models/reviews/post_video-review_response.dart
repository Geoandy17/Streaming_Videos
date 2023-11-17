
import 'package:flutter_netflix_responsive_ui/models/reviews/post_video_review.dart';

class PostVideoReviewsResponse{

  final PostVideoReviews postVideoReviews;
  final String error;

  PostVideoReviewsResponse(this.postVideoReviews, this.error);

  PostVideoReviewsResponse.fromJson(dynamic json)
      : postVideoReviews = PostVideoReviews.fromJson(json),
        error = "";

  PostVideoReviewsResponse.withError(String errorValue)
      : postVideoReviews = PostVideoReviews(),
        error = errorValue;
}
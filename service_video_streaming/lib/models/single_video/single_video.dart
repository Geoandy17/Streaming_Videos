import 'dart:convert';

class SingleVideo {
  final String videoId;
  final int userId;
  final String title;
  final String slug;
  final String description;
  final DateTime datePublication;
  final int views;
  final String type;
  final int likes;
  final int dislikes;
  final int status;
  final int likesStatus;
  final List<SimilarVideo> similarVideo;

  SingleVideo(
      this.videoId,
      this.userId,
      this.title,
      this.slug,
      this.description,
      this.datePublication,
      this.views,
      this.type,
      this.likes,
      this.dislikes,
      this.status,
      this.likesStatus,
      this.similarVideo);

  SingleVideo.fromJson(Map<String,dynamic> data):
      videoId = data['video_id'],
      userId = data['user_id'],
      title = data['title'],
      slug = data['slug'],
      description = data['description'],
      datePublication = data['date_publication'],
      views = data['views'],
        type = data['type'],
      likes = data['likes'],
      dislikes = data['dislikes'],
      status = data['status'],
      likesStatus = data['likes_status'],
        similarVideo = (data["similarVideos"] as List).map((i) => new SimilarVideo.fromJson(i)).toList();

  Map<String ,dynamic> toJson() {
    final Map<String,dynamic> data = new Map<String,dynamic>();
    data['video_id'] = this.videoId;
    data['user_id'] = this.userId;
    data['title'] = this.title;
    data['slug'] =this.slug;
    data['description'] = this.description;
    data['date_publication'] = this.datePublication;
    data['views'] = this.views;
    data['type'] = this.type;
    data['likes'] = this.likes;
    data['dislikes'] = this.dislikes;
    data['status'] = this.status;
    data['likes_status'] = this.likesStatus;
    if(this.similarVideo != null) {
      data['similarVideos'] = this.similarVideo.map((v) => v.toJson()).toList();
    }
    return data;

  }
}


class LikeStatus {
  final int status;

  LikeStatus({this.status});

  LikeStatus.fromJson(Map<String, dynamic> json) :
        status = json['status'];

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['status'] = this.status;
    return data;
  }
}


class SimilarVideo {
  final int videoId;
  final String slug;
  final String title;
  final String type;

  SimilarVideo(this.videoId, this.slug, this.title, this.type);

  SimilarVideo.fromJson(Map<String, dynamic> json)
      :
        videoId = json['videoId'],
        slug = json['slug'],
        title = json['title'],
        type = json['type'];

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['video_id'] = this.videoId;
    data['slug'] = this.slug;
    data['title'] = this.title;
    data['type'] = this.type;

    return data;
  }
}
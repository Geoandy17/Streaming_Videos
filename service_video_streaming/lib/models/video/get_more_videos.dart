
import 'package:flutter_netflix_responsive_ui/models/video/get_more_videos.dart';
import '../links.dart';


class GetMoreVideos {
  final int currentPage;
  final List<VideosData> videosData;
  final String firstPage;
  final int from;
  final int lastPage;
  final String lastPageUrl;
  final List<Links> links;
  final String nextPageUrl;
  final int perPage;
  final String prevPageUrl;
  final int to;
  final int total;

  GetMoreVideos(
      this.currentPage,
      this.videosData,
      this.firstPage,
      this.from,
      this.lastPage,
      this.lastPageUrl,
      this.links,
      this.nextPageUrl,
      this.perPage,
      this.prevPageUrl,
      this.to,
      this.total);
/*  void clearVideoData() {
    VideosData.clear();
  */


  GetMoreVideos.fromJson(Map<String,dynamic> json):
      currentPage = json['current_page'],
      videosData = (json['data'] as List).map((i) => new VideosData.fromJson(i)).toList(),
      firstPage = json['first_page_url'],
      from = json['from'],
      lastPage = json['last_page'],
      lastPageUrl = json['last_page_url'], links = (json["links"] as List).map((i) => new Links.fromJson(i)).toList(),
      nextPageUrl = json['next_page_url'],
      perPage = json['per_page'],
      prevPageUrl = json['prev_page_url'],
      to = json['to'],
      total = json['total'];

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['current_page'] = this.currentPage;
    if (this.videosData != null) {
      data['data'] = this.videosData.map((v) => v.toJson()).toList();
    }
    data['first_page'] = this.firstPage;
    data['from'] = this.from;
    data['last_page'] = this.lastPage;
    data['last_page_url'] = this.lastPageUrl;
    if (this.links != null) {
      data['links'] = this.links.map((v) => v.toJson()).toList();
    }
    data['next_page_url'] = this.nextPageUrl;
    data['per_page'] = this.perPage;
    data['prev_page_url'] = this.prevPageUrl;
    data['to'] = this.to;
    data['total'] = this.total;
    return data;
  }
}






class VideosData {
  final String videoId;
  final String userId;
  final String title;
  final String slug;
  final String description;
  final String image;
  final String status;
  final String likes;
  final String dislikes;


  VideosData(this.videoId, this.userId, this.title, this.slug, this.description,
      this.image, this.status, this.likes, this.dislikes);



  VideosData.fromJson(Map<String,dynamic> json):
        videoId = json['videoId'],
        userId = json['userId'],
        title  = json['title'],
        slug = json['slug'],
        description = json['deccription'],
        image = json['image'],
        status = json['status'],
        likes = json['likes'],
        dislikes = json['dislikes'];

  Map<String,dynamic> toJson() {
    final Map<String,dynamic> data =  new Map<String,dynamic>();
    data['videoId'] = this.videoId;
    data['userId'] = this.userId;
    data['title'] = this.userId;
    data['slug'] = this.slug;
    data['description'] = this.description;
    data['image'] = this.image;
    data['status'] = this.likes;
    data['dislikes'] = this.dislikes;

    return data;
  }
}

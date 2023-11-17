import 'dart:convert';

class Videos {
  final String videoId;
  final String userId;
  final String title;
  final String slug;
  final String description;
  final String image;
  final String status;

  Videos(this.videoId, this.userId, this.title, this.slug, this.description,
      this.image, this.status);


Videos.fromJson(Map<String,dynamic> data):
    videoId = data['videoId'],
    userId = data['userId'],
    title  = data['title'],
    slug = data['slug'],
    description = data['deccription'],
    image = data['image'],
    status = data['status'];

Map<String,dynamic> toJson() {
  final Map<String,dynamic> data = new Map<String,dynamic>();
  data['videoId'] = this.videoId;
  data['userId'] = this.userId;
  data['title'] = this.title;
  data['slug']  = this.slug;
  data['decription'] = this.description;
  data['image'] = this.image;
  data['status'] = this.status;
  return data;
}
}
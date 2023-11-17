import 'dart:convert';

class VideosByChanel {
  final String chanelId;
  final String videoId;
  final DateTime dateTime;

  VideosByChanel(this.chanelId, this.videoId, this.dateTime);

  VideosByChanel.fromJson(Map<String,dynamic> data):
      chanelId = data['chanelId'],
      videoId = data['videoId'],
      dateTime = data['dataTime'];

  Map<String,dynamic> toJson() {
    final Map<String,dynamic> data = new Map<String,dynamic>();
    data['chanelId'] = this.chanelId;
    data['videoId'] = this.videoId;
    data['dateTime'] = this.dateTime;

    return data;
  }

}
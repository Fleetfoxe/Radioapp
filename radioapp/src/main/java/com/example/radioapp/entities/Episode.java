package com.example.radioapp.entities;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Episode {

   @Id
   private long episodeid;
   private String title;
   private long StartTimeUtc;
   private String endTimeUtc;
  // private String program;
   private String ChanId;
   private String imageUrl;

    public Episode() {
    }

    public Episode(long episodeid, String title, long startTimeUtc, String endTimeUtc, String imageUrl) {
        this.episodeid = episodeid;
        this.title = title;
        this.StartTimeUtc = startTimeUtc;
        this.endTimeUtc = endTimeUtc;
        this.imageUrl = imageUrl;
    }

    public Episode(String title, long startTimeUtc) {
        this.title = title;
        StartTimeUtc = startTimeUtc;
    }

    public Episode(String title, long startTimeUtc, String endTimeUtc) {
        this.title = title;
        StartTimeUtc = startTimeUtc;
        this.endTimeUtc = endTimeUtc;
    }

    public Episode(String title, long startTimeUtc, String endTimeUtc, String imageUrl) {
        this.title = title;
        StartTimeUtc = startTimeUtc;
        this.endTimeUtc = endTimeUtc;
        this.imageUrl = imageUrl;
    }

    public Episode(String title) {
        this.title = title;
    }

  /*  public Episode(long id, String title, String starttimeutc, String endtimeutc, String program, long channel, String imageurl) {
        this.id = id;
        this.title = title;
        this.starttimeutc = starttimeutc;
        this.endtimeutc = endtimeutc;
        this.program = program;
        this.channel = channel;
        this.imageurl = imageurl;
    }*/

    public Episode(long episodeid, String title, long starttimeutc, String endtimeutc, String ChanId, String imageUrl) {
        this.episodeid = episodeid;
        this.title = title;
        this.StartTimeUtc = starttimeutc;
        this.endTimeUtc = endtimeutc;
        //this.ChanId = ChanId;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + episodeid +
                ", title='" + title + '\'' +
                ", starttimeutc='" + StartTimeUtc + '\'' +
                ", endtimeutc='" + endTimeUtc + '\'' +
                //", program='" + program + '\'' +
                ", channel id='" + //ChanId + '\'' +
                ", imageurl='" + imageUrl + '\'' +
                '}';
    }

    public long getEpisodeid() {
        return episodeid;
    }

    public void setEpisodeid(long episodeid) {
        this.episodeid = episodeid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStartTimeUtc() {
        return StartTimeUtc;
    }

    public void setStartTimeUtc(long startTimeUtc) {
        this.StartTimeUtc = startTimeUtc;
    }

    public String getEndTimeUtc() {
        return endTimeUtc;
    }

    public void setEndTimeUtc(String endTimeUtc) {
        this.endTimeUtc = endTimeUtc;
    }

  /*  public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }*/

    /*public String getChanId() {
        return ChanId;
    }

     */

    /*public void setChanId(String chanId) {
        this.ChanId = chanId;
    }

     */

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

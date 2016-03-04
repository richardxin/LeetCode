package richardxin.leetcode.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.JsonObject;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)

/**
 * Example of use of "Builder" design pattern
 * 
 * example:
 * Video.Builder builder = new Video.Builder();
 * Video v = builder.setId("[video_id]")
                .setTitle("[video_title]")
                .setStreamingUrl("[streaming_url]")
                .setType("[type]")
                .setDuration("[duration]")
                .build();
 *
 */
public class Video {

    public String id;
    public String title;
    public String type;
    public String streaming_url;
    public Long duration;

    private Video(Builder b) {
        this.id = b.id;
        this.title = b.title;
        this.type = b.type;
        this.streaming_url = b.streamingUrl;
        this.duration = b.duration;
    }

    public static class Builder {

        private String id;
        private String title;
        private String type;
        private String streamingUrl;
        private Long duration;

        public Builder() {
        }

        public Builder(JsonObject jo) {
        }
        
        public Builder setId(String id) {
                this.id = id;
                return this;
        }
        
        public Builder setTitle(String title) {
                this.title = title;
                return this;
        }
        
        public Builder setType (String type) {
                this.type = type;
                return this;
        }
        
        public Builder setStreamingUrl(String streamingUrl) {
                this.streamingUrl = streamingUrl;
                return this;
        }
        
        public Builder setDuration(long duration) {
            this.duration = duration;
            return this;
        }

        public Video build() {
            return new Video(this);
        }
    }
}
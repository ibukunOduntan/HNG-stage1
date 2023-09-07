package com.Zuri;

public class MyResponse {
    private String slack_name;

    private String current_day;
    private String utc_time;
    private String track;

    private String github_file_url;
    private String github_repo_url;

    private int status_code;

    public String getSlack_name() {
        return slack_name;
    }

    public void setSlack_name(String slack_name) {
        this.slack_name = slack_name;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    public String getCurrent_day() {
        return current_day;
    }

    public void setCurrent_day(String current_day) {
        this.current_day = current_day;
    }

    public String getUtc_time() {
        return utc_time;
    }

    public void setUtc_time(String utc_time) {
        this.utc_time = utc_time;
    }

    public String getGithub_repo_url() {
        return github_repo_url;
    }

    public void setGithub_repo_url(String github_repo_url) {
        this.github_repo_url = github_repo_url;
    }

    public int getStatus_code() {
        return status_code;
    }

    public void setStatus_code(int status_code) {
        this.status_code = status_code;
    }

    public String getGithub_file_url() {
        return github_file_url;
    }

    public void setGithub_file_url(String github_file_url) {
        this.github_file_url = github_file_url;
    }


}

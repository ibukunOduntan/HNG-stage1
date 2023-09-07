package com.Zuri;

import org.springframework.web.bind.annotation.*;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

@RestController
@RequestMapping(path = "api")
public class ZuriController {


    @GetMapping("")
    @ResponseBody
    public MyResponse getInfo(
            @RequestParam(name = "slack_name") String slack_name,
            @RequestParam(name = "track") String track) {

        Instant currentUtcTime = Instant.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss'Z'").withZone(ZoneOffset.UTC);
        String formattedTimestamp = formatter.format(currentUtcTime);

        // Convert UTC time to the local time zone (adjust for your desired time zone)
        ZoneId zoneId = ZoneId.of("UTC"); // Use your desired time zone here
        ZonedDateTime zonedDateTime = currentUtcTime.atZone(zoneId);

        // Get the current date
        LocalDate currentDate = zonedDateTime.toLocalDate();

        // Get the day of the week as a String
        String dayOfWeek1 = currentDate.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.getDefault());

        // Validate UTC time is within +/- 2 hours
        boolean isWithinRange = isUtcTimeWithinRange(currentUtcTime);

        // Create a MyResponse object and set the data
        MyResponse response = new MyResponse();
        response.setSlack_name(slack_name);
        response.setCurrent_day(dayOfWeek1);
        response.setTrack(track);
        response.setUtc_time(formattedTimestamp);
        response.setGithub_repo_url("https://github.com/ibukunOduntan/HNG-stage1");
        response.setGithub_file_url("https://github.com/ibukunOduntan/HNG-stage1/blob/main/src/main/java/com/Zuri/Application.java");
        response.setStatus_code(200);
        return response;
    }


    private boolean isUtcTimeWithinRange(Instant utcTime) {
        // Get the current time in the local time zone
        ZoneId zoneId = ZoneId.of("UTC"); // Use your desired time zone here
        ZonedDateTime zonedDateTime = utcTime.atZone(zoneId);
        LocalDateTime localDateTime = zonedDateTime.toLocalDateTime();

        // Get the current time +/- 2 hours
        LocalDateTime currentTimePlus2Hours = LocalDateTime.now().plusHours(2);
        LocalDateTime currentTimeMinus2Hours = LocalDateTime.now().minusHours(2);

        // Check if UTC time falls within the range
        return (localDateTime.isAfter(currentTimeMinus2Hours) && localDateTime.isBefore(currentTimePlus2Hours));
    }

}

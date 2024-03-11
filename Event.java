import java.util.ArrayList;
import java.util.Scanner;

public class Event {
    private String eventID;
    private String eventName;
    private String eventVenue;
    private Date eventDate;
    private ArrayList<String> eventAttendees;

    public Event(String eventID, String eventName, String eventVenue, Date eventDate) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventVenue = eventVenue;
        this.eventDate = eventDate;
        this.eventAttendees = new ArrayList<>();
    }

    public String getEventID() {
        return eventID;
    }

    public void setEventID(String eventID) {
        this.eventID = eventID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventVenue() {
        return eventVenue;
    }

    public void setEventVenue(String eventVenue) {
        this.eventVenue = eventVenue;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public ArrayList<String> getEventAttendees() {
        return eventAttendees;
    }

    public void setEventAttendees(ArrayList<String> eventAttendees) {
        this.eventAttendees = eventAttendees;
    }

    public void organizeEvent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the ID of the event: ");
        eventID = scanner.nextLine();

        System.out.print("Enter the name of the event: ");
        eventName = scanner.nextLine();

        System.out.print("Enter the venue of the event: ");
        eventVenue = scanner.nextLine();

        System.out.print("Enter the date of the event (YYYY-MM-DD): ");
        String dateString = scanner.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            eventDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Invalid date format!");
            return;
        }

        System.out.print("Enter the number of attendees: ");
        int numAttendees = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        for (int i = 0; i < numAttendees; i++) {
            System.out.print("Enter the name of attendee " + (i + 1) + ": ");
            String attendeeName = scanner.nextLine();
            eventAttendees.add(attendeeName);
        }

        System.out.println("Event organized successfully!");
    }

    public void addAttendee(String attendeeName) {
        eventAttendees.add(attendeeName);
    }

    public void removeAttendee(String attendeeName) {
        eventAttendees.remove(attendeeName);
    }

    public void updateAttendee(int index, String newAttendeeName) {
        eventAttendees.set(index, newAttendeeName);
    }

    public String findAttendee(String attendeeName) {
        if (eventAttendees.contains(attendeeName)) {
            return "Attendee found!";
        } else {
            return "Attendee not found!";
        }
    }

    public int getTotalAttendees() {
        return eventAttendees.size();
    }

    @Override
    public String toString() {
        return "Event ID: " + eventID +
                "\nEvent Name: " + eventName +
                "\nEvent Venue: " + eventVenue +
                "\nEvent Date: " + eventDate +
                "\nNumber of Attendees: " + eventAttendees.size();
    }
}
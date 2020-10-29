package seedu.address.model.util;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.Projact;
import seedu.address.model.ReadOnlyProjact;
import seedu.address.model.person.Email;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonName;
import seedu.address.model.person.Phone;
import seedu.address.model.person.TelegramAddress;
import seedu.address.model.tag.MeetingLink;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagName;
import seedu.address.model.tag.TagTask;

/**
 * Contains utility methods for populating {@code Projact} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new PersonName("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new TelegramAddress("alex_yeoh"), getTagNameSet("friends")),
            new Person(new PersonName("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new TelegramAddress("berniceYu"), getTagNameSet("colleagues", "friends")),
            new Person(new PersonName("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new TelegramAddress("char_Oli"), getTagNameSet("CS2100")),
            new Person(new PersonName("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new TelegramAddress("david123"), getTagNameSet("family")),
            new Person(new PersonName("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new TelegramAddress("Irfan_Ibrahim24"), getTagNameSet("CS2101")),
            new Person(new PersonName("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new TelegramAddress("RoyBalak111"), getTagNameSet("colleagues"))
        };
    }

    public static Tag[] getSampleTags() {
        try {
            Tag[] tags = new Tag[] {
                new Tag(new TagName("colleagues"),
                        getTagTaskList(new TagTask("after work party", false)),
                        Optional.of(new MeetingLink("https://zoom.com"))),
                new Tag(new TagName("CS2101"),
                        getTagTaskList(
                                new TagTask("presentation on mon", false),
                                new TagTask("complete user guide", false),
                                new TagTask("email teacher for consultation", false)),
                        Optional.of(
                                new MeetingLink("https://nus-sg.zoom.us/j/96034098506?pwd=b3l6UWpMb25yN1"
                                        + "JlUldTbGdhbTFSdz09"))),
                new Tag(new TagName("CS2100"),
                        getTagTaskList(
                                new TagTask("project meeting at 2pm", true),
                                new TagTask("assignment 1 submission by 23:59", false)),
                        Optional.of(new MeetingLink("https://nus-sg.com"))),
                new Tag(new TagName("family"),
                        getTagTaskList(),
                        Optional.of(new MeetingLink("http://skype.com"))),
                new Tag(new TagName("friends"),
                        getTagTaskList(),
                        Optional.empty())
            };
            return tags;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ReadOnlyProjact getSampleProjact() {
        Projact sampleAb = new Projact();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }

        for (Tag sampleTag : getSampleTags()) {
            sampleAb.addTag(sampleTag);
        }
        return sampleAb;
    }

    /**
     * Returns a tagname set containing the list of strings given.
     */
    public static Set<TagName> getTagNameSet(String... strings) {
        return Arrays.stream(strings)
                .map(TagName::new)
                .collect(Collectors.toSet());
    }

    public static List<TagTask> getTagTaskList(TagTask... tagTasks) {
        return Arrays.stream(tagTasks)
                .collect(Collectors.toList());
    }

    /**
     * Returns a person set containing the list of strings given.
     */
    public static Set<PersonName> getPersonSet(String... strings) {
        return Arrays.stream(strings)
                .map(PersonName::new)
                .collect(Collectors.toSet());
    }

}

package com.mycompany.chatapp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testCheckMessageIDSuccess() {
        Message m = new Message(0, "+27718693002", "Hi tonight");
        m.setMessageID("0012345678");
        assertTrue(m.checkMessageID());
    }

    @Test
    public void testCheckRecipientCellSuccess() {
        Message m = new Message(0, "+27718693002", "Hi tonight");
        assertEquals("Cell phone number successfully captured.", m.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCellFail() {
        Message m = new Message(0, "08575975889", "Hi tonight");
        assertEquals("Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.", m.checkRecipientCell());
    }

    @Test
    public void testCheckMessageLengthSuccess() {
        Message m = new Message(0, "+27718693002", "Hi tonight");
        assertEquals("Message ready to send.", m.checkMessageLength());
    }

    @Test
    public void testCheckMessageLengthFail() {
        String longMsg = "a".repeat(300);
        Message m = new Message(0, "+27718693002", longMsg);
        assertTrue(m.checkMessageLength().contains("exceeds 250 characters"));
    }

    @Test
    public void testCreateMessageHash() {
        Message m = new Message(0, "+27718693002", "Hi tonight");
        m.setMessageID("0012345678");
        assertEquals("00:0:HITONIGHT", m.createMessageHash());
    }

    @Test
    public void testSentMessageSent() {
        Message m = new Message(0, "+27718693002", "Hi tonight");
        assertEquals("Message successfully sent.", m.SentMessage(1));
    }

    @Test
    public void testSentMessageDisregard() {
        Message m = new Message(0, "+27718693002", "Hi tonight");
        assertEquals("Press 0 to delete the message.", m.SentMessage(2));
    }

    @Test
    public void testSentMessageStored() {
        Message m = new Message(0, "+27718693002", "Hi tonight");
        assertEquals("Message successfully stored.", m.SentMessage(3));
    }
}

package com.artsee.backend.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import com.artsee.backend.model.*;
import com.artsee.backend.dao.*;


@ExtendWith(MockitoExtension.class)
public class TestArtistService {

    @Mock
    private ArtistRepository artistDao;

    @InjectMocks
    private ArtseeService service;

    private static final String ARTIST_ID = "1234";
    private static final String EMAIL = "artist@gmail.com";
    private static final String PASSWORD = "password";
    private static final String FIRSTNAME = "John";
    private static final String LASTNAME = "Doe";
    private static final String PHONE_NUM = "8675309";
    private static final Address ADDRESS = new Address();

    @BeforeEach
    public void setMockOutput() {
        lenient().when(artistDao.findById(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
            if(invocation.getArgument(0).equals(ARTIST_ID)) {
                Artist artist = new Artist();
                artist.setUserID(ARTIST_ID);
                
                return artist;
            } else {
                return null;
            }
        });
    }
    
    @Test
    public void testCreateArtist() {
        assertEquals(0, service.getAllArtists().size());


        
    }
    
}

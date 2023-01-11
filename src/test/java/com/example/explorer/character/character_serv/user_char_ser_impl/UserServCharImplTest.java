package com.example.explorer.character.character_serv.user_char_ser_impl;

import com.example.explorer.character.char_repo.PlayerCharterRepo;
import com.example.explorer.character.character_serv.user_char_serv_impl.PlayerCharacterServImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServCharImplTest {
    @Mock
    private PlayerCharterRepo charterRepo;

    @InjectMocks
    private PlayerCharacterServImpl userServChar;
}

package com.example.explorer.utility;

import com.example.explorer.character.model.PlayerCharacter;
import com.example.explorer.character.model.PlayerClasses;
import com.example.explorer.character.model.Race;
import com.example.explorer.items.model.Item;
import com.example.explorer.items.model.Weapon;
import com.example.explorer.user.User_model.UserModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExplorerResponse {

    private Race race;
    private List<Race> raceList;
    private Item item;
    private UserModel userModel;
    private Weapon weapon;
    private PlayerClasses playerClasses;
    private PlayerCharacter playerCharacter;

}

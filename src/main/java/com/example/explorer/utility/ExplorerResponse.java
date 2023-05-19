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

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExplorerResponse {

    private Race race;
<<<<<<< HEAD
    private List<Race> raceList;
=======
>>>>>>> fdfcb05288bd7dd02b25283a1fa8a3bb22ece579
    private Item item;
    private UserModel userModel;
    private Weapon weapon;
    private PlayerClasses playerClasses;
    private PlayerCharacter playerCharacter;

}

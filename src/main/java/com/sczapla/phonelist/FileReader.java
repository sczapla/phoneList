/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sczapla.phonelist;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import static java.nio.file.StandardOpenOption.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.collections.ObservableList;

public class FileReader {

    public FileReader() {
    }

    public List<User> readPhoneList(File file) throws Exception {
        List<User> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(file.toPath())) {
            list = stream.map(s -> new User(s))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    public void writePhoneList(File file, ObservableList<User> userList) {
        try {
            List<String> lista = userList.stream().map(s -> (s.getName() + "," + s.getPhone())).collect(Collectors.toList());
            OpenOption[] options = new OpenOption[] { WRITE, TRUNCATE_EXISTING };
            Files.write(file.toPath(), lista, options);
        } catch (Exception ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

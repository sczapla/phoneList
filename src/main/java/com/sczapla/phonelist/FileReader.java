/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sczapla.phonelist;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private URI uri;

    public FileReader() {
        try {
            uri = getClass().getResource("/phoneList.csv").toURI();
            Map<String, String> env = new HashMap<>();
            env.put("create", "true");
            FileSystem zipfs = FileSystems.newFileSystem(uri, env);
        } catch (IOException ex) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex2) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, ex2);
        }
    }

    public List<User> readPhoneList() throws Exception {
        List<User> list = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(uri))) {
            list = stream.map(s -> new User(s))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            Logger.getLogger(FileReader.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }
    
    public void writePhoneList(){
        
    }
}

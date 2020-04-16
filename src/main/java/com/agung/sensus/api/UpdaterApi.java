package com.agung.sensus.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UpdaterApi {

    @GetMapping("/api/versionbpr")
    public ResponseEntity<UpdaterDto> listUpdate(){

        Updater updater = new Updater();
        updater.setVersion("v20.0331-2.46");
        Updater.Files files = new Updater.Files();
        files.setVid(34);
        files.setName("updater.bep");
        files.setVersion("v20.0331-2.46");
        files.setLink("http://download.beeaccounting.com/beepos/Updater/updater-200407.01.zip");
        updater.setFiles(files);
        updater.setDescription("-[UPDATE] laporan rekap payment\r\n-[UPDATE] setoran kasir debit/kredit\r\n-[BUGFIX] pembayaran penjualan");
        UpdaterDto dto = new UpdaterDto();
        dto.setUpdater(updater);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }



}

package com.agung.sensus.controller;

import com.agung.sensus.dao.*;
import com.agung.sensus.entity.Penduduk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class PendudukController {

    @Autowired
    private PendudukDao pendudukDao;

    @Autowired
    private PekerjaanDao pekerjaanDao;

    @Autowired
    private AgamaDao agamaDao;

    @Autowired
    private PendidikanDao pendidikanDao;

    @Autowired
    private GolonganDarahDao golonganDarahDao;


    @GetMapping("penduduk/list")
    public String daftarPenduduk(Model m, @PageableDefault(size = 10) Pageable pageable,
                                         @RequestParam(name = "value", required = false)String value){
        if (value != null) {
            m.addAttribute("key", value);
            m.addAttribute("data", pendudukDao.findByNamaContainingIgnoreCase(value, pageable));
        } else {
            m.addAttribute("data", pendudukDao.findAll(pageable));
        }
        return "penduduk/list";
    }

    @GetMapping("penduduk/form")
    public String tampilkanForms(@RequestParam(value = "id", required = false) String id, Model model){
        Optional<Penduduk> penduduk = null;

        if(id != null && !id.isEmpty()){
           penduduk = pendudukDao.findById(id);
        }else{
            penduduk = Optional.of(new Penduduk());
        }

        model.addAttribute("data", penduduk.get());
        model.addAttribute("listPekerjaan",pekerjaanDao.findAll() );
        model.addAttribute("listAgama", agamaDao.findAll());
        model.addAttribute("listPendidikan", pendidikanDao.findAll());
        model.addAttribute("listGolonganDarah", golonganDarahDao.findAll());

        return "/penduduk/form";

    }


    @PostMapping("/penduduk/form")
    public String simpanPenduduk(@Valid Penduduk penduduk, BindingResult error, ModelMap mm){

        if(error.hasErrors()){
            mm.addAttribute("penduduk", penduduk);
            mm.addAttribute("listPekerjaan",pekerjaanDao.findAll() );
            mm.addAttribute("listAgama", agamaDao.findAll());
            mm.addAttribute("listPendidikan", pendidikanDao.findAll());
            mm.addAttribute("listGolonganDarah", golonganDarahDao.findAll());
            return "/penduduk/form";
        }
        return "redirect:/penduduk/list";
    }

    @DeleteMapping("/penduduk/delete")
    public String hapusPenduduk(@RequestParam("id") String id){
        Penduduk penduduk = pendudukDao.findById(id).get();
        if(penduduk != null){
            pendudukDao.delete(penduduk);
        }
        return "redirect:/penduduk/list";

    }



}

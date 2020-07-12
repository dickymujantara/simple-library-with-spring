package com.example.simplelibrary.services;

import com.example.simplelibrary.models.Buku;

import java.util.List;

public interface BukuService {
    List<Buku> listBuku();
    Buku store(Buku buku);
    Buku getBuku(Long id);
    void deleteBuku(Long id);
}

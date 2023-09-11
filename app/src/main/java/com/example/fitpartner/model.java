package com.example.fitpartner;

import com.google.firebase.firestore.Exclude;

public class model {
    @Exclude private String id;
    String level, jam, lokasi;
    String imgUrl, judul;
    String userid;
    String status;
    String jadwal, harga;
    String description;
    String rekening;
    String starttime;
    String documentId;
    String TrainerId;
    String namabank, nominal, name;

    public String getNamabank() {
        return namabank;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setNamabank(String namabank) {
        this.namabank = namabank;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrainerId() {
        return TrainerId;
    }

    public void setTrainerId(String trainerId) {
        TrainerId = trainerId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }
    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getRekening() {
        return rekening;
    }

    public void setRekening(String rekening) {
        this.rekening = rekening;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJadwal() {
        return jadwal;
    }

    public void setJadwal(String jadwal) {
        this.jadwal = jadwal;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public model() {
    }

    public model(String level, String  status, String rekening, String jam, String TrainerId, String lokasi, String starttime, String imgUrl, String judul, String userid, String jadwal, String harga, String description, String documentId, String namabank, String nominal,String name) {
        this.level = level;
        this.jam = jam;
        this.lokasi = lokasi;
        this.imgUrl = imgUrl;
        this.judul = judul;
        this.userid = userid;
        this.jadwal = jadwal;
        this.harga = harga;
        this.name = name;
        this.nominal = nominal;
        this.namabank= namabank;
        this.description = description;
        this.rekening = rekening;
        this.starttime = starttime;
        this.TrainerId = TrainerId;
        this.status = status;

    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }
}

package com.example.studentRegSystem.service;

import com.example.studentRegSystem.domain.AcademicUnit;

import java.rmi.RemoteException;
import java.util.List;

public interface AcademicService {
    AcademicUnit insertAcademicUnit(AcademicUnit academic) throws RemoteException;

    AcademicUnit selectAcademicUnit(int academicUnitId)throws RemoteException;

    List<AcademicUnit> selectAllAcademicUnit()throws RemoteException;

    boolean deleteAcademicUnit(int id) throws RemoteException;

    AcademicUnit updateAcademicUnit(int id,String name) throws RemoteException;
}

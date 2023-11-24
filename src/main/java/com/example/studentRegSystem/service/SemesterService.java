package com.example.studentRegSystem.service;

import com.example.studentRegSystem.domain.Semester;

import java.rmi.RemoteException;
import java.util.List;

public interface SemesterService {
    Semester insertSemester(Semester semester)throws RemoteException;

    Semester selectSemester(int semesterId)throws RemoteException;

    List<Semester> selectAllSemesters()throws RemoteException;

    boolean deleteSemester(int id)throws RemoteException;

    Semester updateSemester(Semester semester)throws RemoteException;
}

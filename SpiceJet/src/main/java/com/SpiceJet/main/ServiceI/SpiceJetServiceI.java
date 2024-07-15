package com.SpiceJet.main.ServiceI;

import java.util.List;

import com.SpiceJet.main.model.Flight;

public interface SpiceJetServiceI {

	public Flight SaveSpiceJetInfo(Flight mt);

	public List getSpiceJetData();

	public void updateData(int Id, Flight myt);

	public void deleteData(int makemytripflightId);

}

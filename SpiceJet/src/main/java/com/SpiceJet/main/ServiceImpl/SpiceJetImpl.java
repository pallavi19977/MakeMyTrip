package com.SpiceJet.main.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpiceJet.main.Repository.SpiceJetRepository;
import com.SpiceJet.main.ServiceI.SpiceJetServiceI;
import com.SpiceJet.main.model.Flight;

@Service
public class SpiceJetImpl implements SpiceJetServiceI
{
	@Autowired
	private SpiceJetRepository sr;

	@Override
	public Flight SaveSpiceJetInfo(Flight mt) 
	{
		Flight mmt=sr.save(mt);
		return mmt;
	}

	@Override
	public List getSpiceJetData() 
	{
		return sr.findAll();
	}

	@Override
	public void updateData(int id, Flight myt) 
	{
		Optional<Flight>opMyt=sr.findById(id);
		if(opMyt.isEmpty())
		{
		sr.save(myt);
		}
		else
		{
			throw new RuntimeException("User ID is Not Present");
		}
	}


	@Override
	public void deleteData(int makemytripflightId) 
	{
		sr.deleteById(makemytripflightId);
	}

	
	
	
}

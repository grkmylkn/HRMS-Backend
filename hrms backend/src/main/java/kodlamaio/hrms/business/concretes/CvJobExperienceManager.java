package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvJobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvJobExperienceDao;
import kodlamaio.hrms.entities.concretes.CvJobExperience;

@Service
public class CvJobExperienceManager implements CvJobExperienceService{

	private CvJobExperienceDao cvJobExperienceDao;

	@Autowired
	public CvJobExperienceManager(CvJobExperienceDao cvJobExperienceDao) {
		super();
		this.cvJobExperienceDao = cvJobExperienceDao;
	}

	@Override
	public DataResult<List<CvJobExperience>> getall() {
		return new SuccessDataResult<List<CvJobExperience>>(this.cvJobExperienceDao.findAll(),"Data listed.");
	}

	@Override
	public Result add(CvJobExperience cvJobExperience) {
		this.cvJobExperienceDao.save(cvJobExperience);
		return new SuccessResult("Job experience added.");
	}
	
}

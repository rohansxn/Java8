import java.util.stream.Collectors;
import java.lang.reflect.Array;
import java.util.*;

public class countryUtility implements ICountry {
	@Override
	public Boolean searchCountry(List<String> countries, String searchCountry) throws countryNotFoundException
	{   
		if(countries.size()>0 && searchCountry != null){
			Optional<String> result = countries.stream().filter(s->s.equals(searchCountry)).findAny(); 
			if(!result.isPresent()){
				throw new countryNotFoundException("Country Not Found");
			}
			return true;
		}
		else if(countries.size()==0 && searchCountry == null){
		return false;
		}
		else{
			return false;
			}
		
	}

	@Override
	public List<String> sortCountries(List<String> countries) throws countryNotFoundException{
		if(countries.size()>0 && countries != null){
			List<String> sortedList = countries.stream().sorted().collect(Collectors.toList());
			return sortedList;
		}
		else
		return null;
	}

	@Override
	public List<String> getDistinctCountriesInUpperCaseSortedByLength(List<String> countries) throws countryNotFoundException{
		List<String> distinctCountries = countries.stream().sorted(Comparator.comparingInt(String::length))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
		return distinctCountries;
	}

	@Override
	public String getCountryByCapital(Map<String, String> countries, String searchCapital) throws countryNotFoundException{
		Optional<String> country = countries.entrySet().stream()
				  .filter(e -> searchCapital.equals(e.getValue()))
				  .map(Map.Entry::getKey)
				  .findFirst();
		String result= country.get();
		//System.out.println("This is Country"+country);
		return result;
	}
	public static void main(String[] args) {
		countryUtility cu = new countryUtility();
		List<String> names = new ArrayList<String>();
		Map<String,String> names1 = new HashMap<>();
		names1.put("India", "Delhi");
		names1.put("USA", "Washington");
		names1.put("Canada", "Ottawa");
		names.add("India");
		names.add("USA");
		names.add("Russia");
		names.add("Australia");
		String con = "Patna";
		String get;
		List<String> cont = new ArrayList<String>();
		List<String> ss = new ArrayList<String>();
		boolean dsf;
		try {
			//dsf = cu.searchCountry(names, con);
		//cont = cu.sortCountries(names);
			//get = cu.getCountryByCapital(names1, con);
			ss= cu.getDistinctCountriesInUpperCaseSortedByLength(names);
			System.out.println("This is value :"+ss);
		} catch (countryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}
}

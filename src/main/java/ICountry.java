import java.util.*;

public interface ICountry {
   abstract Boolean searchCountry(List<String> countries, String searchCountry) throws countryNotFoundException;
   abstract List<String> sortCountries(List<String> countries) throws countryNotFoundException;
   abstract List<String> getDistinctCountriesInUpperCaseSortedByLength(List<String> countries) throws countryNotFoundException;
   abstract String getCountryByCapital(Map<String, String> countries, String searchCapital) throws countryNotFoundException;

}

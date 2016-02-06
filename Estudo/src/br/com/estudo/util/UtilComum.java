package br.com.estudo.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import sun.misc.Regexp;
import sun.security.util.Length;

public class UtilComum {
	public static int calcularIdade(Date dataNascimento) {
		if (dataNascimento != null) {
			Calendar now = Calendar.getInstance();
			Calendar clone = Calendar.getInstance();
			clone.setTime(dataNascimento); // Otherwise changes are been
											// reflected.
			int years = -1;
			while (!clone.after(now)) {
				clone.add(Calendar.YEAR, 1);
				years++;
			}

			return years;
		} else {
			return 0;
		}
	}

	public static void gravarArquivo(byte[] arquivo, String pathArquivo) throws IOException {
		FileOutputStream fos = new FileOutputStream(pathArquivo);
		fos.write(arquivo);
		fos.close();
	}

	public static String recuperarTextoArquivo(String pathArquivo) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(pathArquivo));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}

			return sb.toString();
		} finally {
			br.close();
		}
	}

	public static String recuperarPropriedadeEstudoApp(String propriedade) throws IOException {
		Properties prop = new Properties();
		String propFileName = "EstudoApp.properties";

		InputStream input = UtilComum.class.getClassLoader().getResourceAsStream(propFileName);

		// load a properties file
		prop.load(input);

		return prop.getProperty(propriedade);
	}

	public static Date converterTextoData(String dataSTR) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date d = formatter.parse(dataSTR);
		return d;
	}

	public static boolean validarEmail(String email) {
		boolean isEmailIdValid = false;
		if (email != null && email.length() > 0) {
			String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
			Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(email);
			if (matcher.matches()) {
				isEmailIdValid = true;
			}
		}
		return isEmailIdValid;
	}

	public static boolean validarValor(String valor) {
		boolean valorValido = true;
		double numero = 0;
		try {
			numero = Double.parseDouble(valor);
		} catch(Exception exception){
			valorValido = false;
		}
		return valorValido;
		
	}

}

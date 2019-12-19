package com.zero.my_generator.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDemo {
	public static void main(String[] args) throws IOException {

		Path path = Paths.get("E:/zip", "noSign", "haha");
		if (Files.notExists(path, LinkOption.NOFOLLOW_LINKS))
			Files.createDirectories(path);
		try (// ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
				OutputStream out = new FileOutputStream("E:/zip/noSign/zip.zip");
				ZipOutputStream zipOutputStream = new ZipOutputStream(out);
				InputStream in = new FileInputStream("E:/test.txt");) {

			ZipEntry zipEntry = new ZipEntry("hah/");

			// zipEntry.
			// zipEntry.

			zipOutputStream.putNextEntry(zipEntry);
			zipOutputStream.closeEntry();
			zipOutputStream.putNextEntry(new ZipEntry("hah/copy.txt"));
			int c;
			while ((c = in.read()) != -1)
				zipOutputStream.write(c);
			zipOutputStream.closeEntry();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

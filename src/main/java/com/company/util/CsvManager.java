package com.company.util;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;
import static java.nio.charset.StandardCharsets.UTF_8;


@Log4j2
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CsvManager {
    private static final long TITLE_ROW = 1;
    private static final int EXPECTED_COLUMNS_AMOUNT = 1;
    private static final int HEADER_INDEX = 0;
    private static final String EMPTY_FILE_FAIL_MESSAGE = "Cannot provide data from empty file";
    private static final String RESOURCE_PATH = "src/main/resources";


    @SneakyThrows(IOException.class)
    public static <T> List<T> getCsvDataAsList(String csvFilePath, Class<T> classType) {
        try (FileReader file = new FileReader(csvFilePath)) {
            return new CsvToBeanBuilder<T>(file)
                    .withType(classType)
                    .build()
                    .parse();
        }
    }


    private static List<String> getCsvDataByHeader(String relativeCsvFilePath, String headerValue) throws Exception {
        Optional<List<String>> chatbotIntentExpressions = Optional.empty();
        try (CSVReader reader = new CSVReader(new FileReader(getResource(relativeCsvFilePath), UTF_8))) {
            List<String[]> extractedRows = reader.readAll();
            verifyCsvHeader(extractedRows.get(HEADER_INDEX), headerValue);
            chatbotIntentExpressions = Optional.of(extractedRows
                    .stream()
                    .skip(TITLE_ROW)
                    .flatMap(Stream::of)
                    .collect(Collectors.toList()));
        } catch (IOException | CsvException e) {
            log.error(e.getMessage());
        }
        return chatbotIntentExpressions.orElseThrow(() -> new Exception(EMPTY_FILE_FAIL_MESSAGE));
    }


    private static void verifyCsvHeader(String[] csvHeaders, String headerValue) throws CsvException {
        if (csvHeaders.length > EXPECTED_COLUMNS_AMOUNT || !csvHeaders[HEADER_INDEX].equalsIgnoreCase(headerValue)) {
            throw new CsvException(format(".csv file should contains only 1 column with '%s' title%n But have%n Length: '%d'%n Title : '%s'", headerValue,
                    csvHeaders.length, csvHeaders[HEADER_INDEX]));
        }
    }

    private static String getResource(String csvFilePath) {
        return Optional.of(Paths.get(RESOURCE_PATH, csvFilePath).toFile().getAbsolutePath())
                .orElseThrow(() -> new RuntimeException(".csv file is missing"));
    }
}
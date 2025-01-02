package com.application.util;

public class LivrosUtil {

        public static boolean validarISBN(String isbn) {
            if (isbn == null || isbn.isEmpty()) {
                return false;
            }

            isbn = isbn.replaceAll("[^0-9X]", "");

            if (isbn.length() == 13) {
                return validarISBN13(isbn);
            } else if (isbn.length() == 10) {
                return validarISBN10(isbn);
            }

            return false;
        }

        private static boolean validarISBN13(String isbn) {
            int soma = 0;
            for (int i = 0; i < 12; i++) {
                int digito = Character.getNumericValue(isbn.charAt(i));
                soma += (i % 2 == 0) ? digito : digito * 3;
            }

            int digitoVerificador = 10 - (soma % 10);
            if (digitoVerificador == 10) {
                digitoVerificador = 0;
            }

            return digitoVerificador == Character.getNumericValue(isbn.charAt(12));
        }

        private static boolean validarISBN10(String isbn) {
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Character.getNumericValue(isbn.charAt(i));
                soma += digito * (10 - i);
            }

            char digitoVerificador = isbn.charAt(9);
            int digitoVerificadorInt = (digitoVerificador == 'X') ? 10 : Character.getNumericValue(digitoVerificador);

            return soma % 11 == digitoVerificadorInt;
        }

}

  private static final String DD_MM_YY = "ddMMyy";
    private static final String YYYY_MM_DD = "yyyy-MM-dd";
    private static final String YYYY_MM_DD_HMS = "yyyy-MM-dd HH:mm:ss";
    private static final String DD_MM_YYYY = "dd/MM/yyyy";
    private static final String DD_MM_YYYY_HH_MM_SS = "dd/MM/yyyy HH:mm:ss.SS";
    
       
    public static void main(String[] args) {



        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DD_MM_YY);
        LocalDate localDate = LocalDate.now();
        String dateFormated = localDate.format(formatter);
        System.out.println(dateFormated);
    }
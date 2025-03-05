   public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(() -> {
           sendEmail("information");
        });
    }

    static void sendEmail(String information) {
        // code here ...
    }
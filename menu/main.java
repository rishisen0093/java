    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu, menu); // Ensure activity_main_menu.xml exists
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.new_mail) {
            Toast.makeText(this, "A new mail is composed", Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.reply) {
            Toast.makeText(this, "A new mail is replied", Toast.LENGTH_LONG).show();
        } else if (itemId == R.id.forward) {
            setContentView(R.layout.registrationpage); // Ensure registrationpage.xml exists
        }

        return true;
    }

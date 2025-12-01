# UASLabPBOB_6
Ini adalah implementasi aplikasi restoran sederhana (Java). Saya menambahkan sebuah Command Line Interface (CLI) pada project ini tanpa mengubah file lain selain menambahkan `src/cli/CLI.java`.

## CLI (Command Line Interface) — Petunjuk dan Contoh
CLI baru dibuat di `src/cli/CLI.java` dan menyediakan dua mode utama: single-command (non-interaktif) dan session (REPL) untuk menjaga state `RestaurantSystem` selama proses berjalan.

Catatan: `run.bat` dan `run.sh` tetap tidak diubah dan masih menjalankan `RestaurantDriver` seperti sebelumnya.

Cara compile & menjalankan (Windows - PowerShell):

```powershell
Get-ChildItem -Path src -Recurse -Include *.java | ForEach-Object { $_.FullName } | Out-File -Encoding ASCII build_sources.txt
cmd /c "javac -cp .;lib\gson-2.10.1.jar -d src @build_sources.txt"
cmd /c "java -cp src;lib\gson-2.10.1.jar cli.CLI help"
```

Contoh perintah (non-interaktif):

```powershell
cmd /c "java -cp src;lib\gson-2.10.1.jar cli.CLI list-menu"
cmd /c "java -cp src;lib\gson-2.10.1.jar cli.CLI list-tables"
cmd /c "java -cp src;lib\gson-2.10.1.jar cli.CLI start-order --customer shara --table 3"
cmd /c "java -cp src;lib\gson-2.10.1.jar cli.CLI add-item --customer shara --item kopi --qty 1 --note dingin"
cmd /c "java -cp src;lib\gson-2.10.1.jar cli.CLI confirm --customer shara"
cmd /c "java -cp src;lib\gson-2.10.1.jar cli.CLI pay --customer shara --method cash"
```

Contoh menjalankan session (REPL) agar state tetap dipertahankan antar perintah:

```powershell
cmd /c "java -cp src;lib\gson-2.10.1.jar cli.CLI session"
# di dalam session, contoh urutan:
> start-order --customer shara --table 3
> add-item --customer shara --item kopi --qty 1 --note dingin
> confirm --customer shara
> process-kitchen
> process-delivery
> pay --customer shara --method cash
> exit
```

Mode `interactive` mem-forward ke `RestaurantDriver` bawaan (UI console asli) — jalankan dengan `cli.CLI interactive`.

Semua pesan di CLI ditulis dalam Bahasa Indonesia.


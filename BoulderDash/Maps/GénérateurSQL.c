#include <stdio.h>
int main ( void )
{
   static const char filename[] = "Map1.txt";
   FILE *file = fopen ( filename, "r" );
   if ( file != NULL )
   {
      char line [ 128 ];
      while ( fgets ( line, sizeof line, file ) != NULL )
      {
         printf("%s", line);
      }
      fclose ( file );
   }
   else
   {
      perror ( filename );
   }
//   for i < 20{
//     for i < 20{
//       printf()
//     }
//   }
   return 0;
}

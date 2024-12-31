using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace QL_Nha_Tro_Demo
{
    public class TripleDES
    {
        //Khai báo khóa
        private byte[] key;
        //Khai báo Vector
        private byte[] iv;

        TripleDESCryptoServiceProvider DES = new TripleDESCryptoServiceProvider();
        //Hàm khởi tạo
        public TripleDES ()
        {
            //24 ký tự bất kỳ
            key = System.Text.UnicodeEncoding.UTF8.GetBytes("123*45#hgk&^$#!df*7^3)g-");
            //8 ký tự bất kỳ
            iv = System.Text.UnicodeEncoding.UTF8.GetBytes("456%Q&$#");
        }

        public TripleDES(string _key, string _iv)
        {
            key = System.Text.UnicodeEncoding.UTF8.GetBytes(_key);
            iv = System.Text.UnicodeEncoding.UTF8.GetBytes(_iv);
        }

        //Hàm mã hóa
        public string MaHoa(string strToEnCrypt)
        {
            byte[] input = System.Text.UnicodeEncoding.UTF8.GetBytes(strToEnCrypt);
            MemoryStream output = new MemoryStream();
            CryptoStream objCryptoStream = new CryptoStream(output, DES.CreateEncryptor(key,DES.IV), CryptoStreamMode.Write);
            objCryptoStream.Write(input, 0, input.Length);
            objCryptoStream.FlushFinalBlock();
            return Convert.ToBase64String(output.ToArray());
        }

        //Hàm Giải mã

        public string GiaiMa(string strToDeCrypt)
        {
            byte[] input = Convert.FromBase64String(strToDeCrypt);
            MemoryStream output = new MemoryStream();
            CryptoStream objCryptoStream = new CryptoStream(output, DES.CreateDecryptor(key, iv), CryptoStreamMode.Write);
                objCryptoStream.Write(input, 0, input.Length);
                objCryptoStream.FlushFinalBlock();
            return System.Text.UnicodeEncoding.UTF8.GetString(output.ToArray());
        }
    }
}

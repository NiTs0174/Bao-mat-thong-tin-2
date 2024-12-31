namespace QL_Nha_Tro_Demo.Entities
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("SDDV")]
    public partial class SDDV
    {
        [Key]
        public int idSDDV { get; set; }

        public int maDV { get; set; }

        public int maThuePhong { get; set; }

        public int? soLuong { get; set; }

        public double? thanhTien { get; set; }

        public DateTime? ngaySD { get; set; }

        public virtual DichVu DichVu { get; set; }

        public virtual ThuePhong ThuePhong { get; set; }
    }
}

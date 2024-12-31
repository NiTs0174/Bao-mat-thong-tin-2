namespace QL_Nha_Tro_Demo.Entities
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;
    using System.Data.Entity.Spatial;

    [Table("NhanVien")]
    public partial class NhanVien
    {
        [Key]
        public int maNV { get; set; }

        [StringLength(50)]
        public string tenNV { get; set; }

        [Column(TypeName = "date")]
        public DateTime? ngaySinh { get; set; }

        [StringLength(50)]
        public string gioiTinh { get; set; }

        [StringLength(50)]
        public string soDT { get; set; }

        [StringLength(50)]
        public string email { get; set; }

        [StringLength(50)]
        public string luong { get; set; }
    }
}
